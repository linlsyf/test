

[![codecov](https://codecov.io/gh/linlsyf/test/graph/badge.svg?token=TGB3H8KEN5)](https://codecov.io/gh/linlsyf/test)



===========文件目录=======
--java
      CalculateStrategy  策略执行接口
--test
      TaskTest 执行测试

-run.sh 执行部署运行文件

==========核心代码===========

CalculatorContext 根据不同传入类型 执行不同的策略

testRemove 方法测试移除重复值
  testReplace   方法测试替换重复值

impl 文件夹下 定义不同类具体实现筛选和打印



  ======代码地址=========
  https://github.com/linlsyf/test

  =====其他===
  java -jar test.jar CharactersMainTest  aabcccbbad  abcccbad


