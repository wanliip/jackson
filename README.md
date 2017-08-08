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