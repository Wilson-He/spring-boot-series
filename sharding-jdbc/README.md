
- 导入order.sql文件语句生成相应库与表
- order_info表仅用于文件逆向生成，不进行数据存储
- mybatis plus 3.1.1后的版本由于依赖mybatis的版本更新到3.5.2导致时间类型转换成LocalDateTime类型失效，所以使用3.1.0版本
- mybatis plus的insert语句格式紊乱，所以个人通过编写ExtMybatisXMLLanguageDriver继承MybatisXMLLanguageDriver类将Mybatis plus中的动态语句重新格式化