package XMLDemo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class XMLDemo01 {
    public static void main(String[] args) throws IOException {
        String path = XMLDemo01.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements student = document.getElementsByTag("name");  // 根据标签名称获取
//        System.out.println(student.size());
//        for (Element element : property) {
//            System.out.println(element);
//        }
//        System.out.println(student.get(0).text());
        Elements number = document.getElementsByAttribute("number");   // 根据属性名获取
        Elements attributeKey = document.getElementsByAttributeValue("number", "test_02");  // 根据属性及属性值获取
        System.out.println(number.get(0).text());
        System.out.println(attributeKey.get(0).text());
        Elements ele_stu = document.getElementsByTag("student");
        Element stu_1 = ele_stu.get(0);  // 通过Element 对象获取子标签
        System.out.println(stu_1.getElementsByTag("name").size());  // 通过Element 对象获取子标签
        System.out.println(stu_1.attr("number"));  // 通过ELement获取属性值
        System.out.println(stu_1.text()); // 通过ELement对象获取文本值.text()方法如果有子标签只获取子标签内所有文本内容
        System.out.println(stu_1.html()); // 通过ELement对象获取文本值.html()方法如果有子标签会获取子标签的html形式文本

    }
}
