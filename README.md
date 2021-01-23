# Spock in Action

1. 将 spock 测试用例放置在 `src/test/groovy` 包下。
2. 所有的 spock 测试用例类都必须实现 `Specification` 接口。
3. spock 的 `feature`术语 类似 junit 的测试方法。
4. 什么是行为驱动开发(behavior driven development): given-when-then
5. 使用 spock 使用 `block`特性 划分测试的不同步骤，例如 `expect`。

> Blocks are a Spock native way of breaking up
> the phases of our test using labels.

1. given/setup
2. when: where we invoke our method under test.
3. then: where the assertions belong, these are evaluated as plain boolean assertions.
4. expect: the combo of when and then.
5. cleanup

*within the then and expect blocks, assertions are implicit.
*data driven testing is when we test the same behavior multiple times with different parameters and assertions.

Mocking 
1. [more details](https://www.baeldung.com/mockito-vs-easymock-vs-jmockit)
