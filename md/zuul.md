## 几点注意事项

### sensitiveHeaders 和 ignoredHeaders

**sensitiveHeaders**会过滤客户端附带的headers
例如：
sensitiveHeaders: X-ABC
*如果客户端在发请求是带了X-ABC，那么X-ABC不会传递给下游服务*

**ignoredHeaders**会过滤服务之间通信附带的headers
例如：
ignoredHeaders: X-ABC
*如果客户端在发请求是带了X-ABC，那么X-ABC依然会传递给下游服务。但是如果下游服务再转发就会被过滤*

还有一种情况就是客户端带了X-ABC，在ZUUL的Filter中又addZuulRequestHeader("X-ABC", "new"),
那么客户端的X-ABC将会被覆盖，此时不需要sensitiveHeaders。如果设置了sensitiveHeaders: X-ABC，那么Filter中设置的X-ABC依然不会被过滤。