# jackson
json解析
json解析

使用jackson 对json 数据基本解析使用

dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.5.3</version>
</dependency>

/**
         
        * ObjectMapper 是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
        * ObjectMapper 有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1) 把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1) 把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0) 把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0) 把arg0转成json序列，并把结果输出成字符串。
         */

JSON注解：
Jackson提供了一系列注解，方便对JSON序列化和反序列化进行控制，下面介绍一些常用的注解。
@JsonIgnore 此注解用于属性上，作用是进行JSON操作时忽略该属性。
@JsonFormat 此注解用于属性上，作用是把Date类型直接转化为想要的格式，如@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")。
@JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name，@JsonProperty("name")。
@JsonIgnoreProperties(ignoreUnknown = true)  //当json转对象时候，json中存在obj不存在的字段，会报错，此注解可以忽略obj中不存在的字段

@JsonIgnoreProperties
1、作用在类上，用来说明有些属性在序列化/反序列化时需要忽略掉，可以将它看做是@JsonIgnore的批量操作，但它的功能比@JsonIgnore要强，比如一个类是代理类，我们无法将将@JsonIgnore标记在属性或方法上，此时便可用@JsonIgnoreProperties标注在类声明上，
2、它还有一个重要的功能是作用在反序列化时解析字段时过滤一些未知的属性，否则通常情况下解析到我们定义的类不认识的属性便会抛出异常。
可以注明是想要忽略的属性列表如@JsonIgnoreProperties({"name","age","title"})，
也可以注明过滤掉未知的属性如@JsonIgnoreProperties(ignoreUnknown=true)
