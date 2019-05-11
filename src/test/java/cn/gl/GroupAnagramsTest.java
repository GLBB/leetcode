package cn.gl;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    @Test
    public void test1() throws InterruptedException {
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Arrays.stream(data)
                .flatMap(subData -> Arrays.stream(subData))
                .forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        Map<Integer, Hosting> map = list.stream().collect(Collectors.toMap(Hosting::getId, hosting -> {
            System.out.println(hosting);
            return hosting;
        }));
        System.out.println(map);
    }

    // collect 操作
    @Test
    public void test3(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        Arrays.stream(strs)
//                .collect()

        String str = "eat";
        String s = str.chars()
                .sorted()
                .collect(StringBuilder::new, (sb, i)->{
                    sb.append((char)i);
                }, StringBuilder::append)
                .toString();
        System.out.println(s);
    }

    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer res = list.stream()
                .collect(() -> {
                    return new Integer[]{0};
                }, (sumArr, i) -> {
                    sumArr[0] = sumArr[0] + i;
                }, (sumArr1, sumArr2) -> {
                    sumArr1[0] += sumArr2[0];
                })[0];
        System.out.println(res);
    }


    static class Person{
        String type;
        String name;

        public Person(String type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void test5(){
        Person p1 = new Person("China", "张三");
        Person p2 = new Person("China", "李四");
        Person p3 = new Person("American", "tom");
        Person p4 = new Person("Janpan", "pony");
        var list = new ArrayList<Person>();
        Collections.addAll(list, p1, p2, p3,p4);
        HashMap<String, List<Person>> res = list.stream()
                .collect(HashMap<String, List<Person>>::new,
                        (map, p) -> {
                            List<Person> pList = map.getOrDefault(p.type, new ArrayList<>());
                            pList.add(p);
                            map.put(p.type, pList);
                        }, HashMap::putAll);
        System.out.println(res);
    }

    @Test
    public void test6(){
        String str = "bca";
//        str.chars().sorted().map(i->(char)i).collect(Collectors.joining())
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.joining(",")));
    }


}


class Hosting {
    private int Id;
    private String name;
    private long websites;
    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }
    //getters, setters and toString()


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

//    @Override
//    public String toString() {
//        return "Hosting{" +
//                "Id=" + Id +
//                ", name='" + name + '\'' +
//                ", websites=" + websites +
//                '}';
//    }
}