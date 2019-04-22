package test.easy;

/**
 * Created by mengyue on 2018/7/25.
 */
public class 查找重复的电子邮箱 {

    /**
     *
     *
     Create table If Not Exists Person (Id int, Email varchar(255))
     Truncate table Person
     insert into Person (Id, Email) values ('1', 'a@b.com')
     insert into Person (Id, Email) values ('2', 'c@d.com')
     insert into Person (Id, Email) values ('3', 'a@b.com')
     *
     *
     *
     *
     *
     *  编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
     *
     +----+---------+
     | Id | Email   |
     +----+---------+
     | 1  | a@b.com |
     | 2  | c@d.com |
     | 3  | a@b.com |
     +----+---------+
     *
     *
     *
     *根据以上输入，你的查询应返回以下结果：
     *
     +---------+
     | Email   |
     +---------+
     | a@b.com |
     +---------+
     *
     *
     * 说明：所有电子邮箱都是小写字母。
     *
     *
     *  答案：
     *  SELECT Email FROM Person GROUP BY Email HAVING COUNT(id) >1
     */
}
