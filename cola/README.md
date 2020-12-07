Cola各层概念定义：
- Adapter层：路由用户request + 适配response。
  - web：存放web端controller
  - mobile：移动端处理
- App层：接收请求，根据领域划分包，联合domain层一起做业务处理。
- Domain层：领域模型 + 领域能力, 根据领域划分包。
- Infrastructure层：技术细节（DB，Search，RPC…） + 防腐（Anti-corruption）。
- client层：暴露service接口服务与所需DTO