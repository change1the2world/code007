class JointFunction {
  var s1 = '''gdg'
      'fdfdfs'
      'dgdf''';
  call(String a, String b, String c, String d) => '$a $b $c $d';
}
FunX(a, {b, c:3, d:4, e})
{
  print('$a $b $c $d $e');
}
FunY(a, [b, c, d, e])
{
  print('$a $b $c $d $e');
}

void main() {
  var hero = ['张无忌', '风清扬', '张三丰', '独孤求败', '萧峰'];
  var heros = <String>{};
  heros.add('石破天');
  heros.addAll(hero);
  var jf = JointFunction();
//  var fun = jf("放", "手", "去", "做");
//  print(fun);
  hero.forEach((i){
    print("${hero.indexOf(i)},"+i);
  });
}
