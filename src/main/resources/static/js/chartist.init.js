new Chartist.Bar('#distributed-series', {
  labels: ['关系型数据库', '分布式数据库', '图数据库'],
  series: [20, 60, 10000]
}, {
  distributeSeries: true,
  plugins: [
    Chartist.plugins.tooltip()
  ]
})