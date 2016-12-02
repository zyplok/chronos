package org.apache.mesos.chronos.scheduler.config

import com.codahale.metrics.MetricRegistry
import com.google.inject.{AbstractModule, Provides, Scopes, Singleton}
import org.apache.mesos.chronos.scheduler.jobs.{JobMetrics, MetricReporterService}

/**
  * Author: @andykram
  */


class JobMetricsModule(config: GraphiteConfiguration) extends AbstractModule {

  def configure() {
    bind(classOf[JobMetrics]).in(Scopes.SINGLETON)
  }

  @Provides
  @Singleton
  def provideMetricReporterService(registry: MetricRegistry) = {
    new MetricReporterService(config, registry)
  }
}
