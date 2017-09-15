<?php
/*
*          ┌─┐       ┌─┐
*       ┌──┘ ┴───────┘ ┴──┐
*       │                 │
*       │       ───       │
*       │  ─┬┘       └┬─  │
*       │                 │
*       │       ─┴─       │
*       │                 │
*       └───┐         ┌───┘
*           │         │
*           │         │
*           │         │
*           │         └──────────────┐
*           │                        │
*           │                        ├─┐
*           │                        ┌─┘    
*           │                        │
*           └─┐  ┐  ┌───────┬──┐  ┌──┘         
*             │ ─┤ ─┤       │ ─┤ ─┤         
*             └──┴──┘       └──┴──┘ 
*                 神兽保佑 
*                 代码无BUG! 
*/

$mysql_server_name='127.0.0.1'; //改成自己的mysql数据库服务器
$mysql_server_port=3306;//端口
$mysql_username='root'; //改成自己的mysql数据库用户名
$mysql_password='123456'; //改成自己的mysql数据库密码
$mysql_database='demo'; //改成自己的mysql数据库名

$conn=mysql_connect("{$mysql_server_name}:{$mysql_server_port}",$mysql_username,$mysql_password) or die("error connecting") ; //连接数据库
mysql_query("set names 'utf8'"); //数据库输出编码 
mysql_select_db($mysql_database); //打开数据库


add(20); 
add(50); 
add(100); 
add(1000); 
 
function add($num) { 
    $num = $num * 10000; 
    // 生产sql语句 
    for ($i = 0; $i < $num; $i++) { 
        $level = rand(0, 100); 
        $date  = rand(strtotime('2017-01-01 00:00:00'), strtotime('2017-12-30 23:59:59')); 
        $date  = date("Y-m-d H:i:s", $date); 
        $info  = "info_msg"; 
        $table1 = 'log_'.($num/10000).'_1'; 
        $sql = createSql($level, $date, $info, $table1); 
    } 
    for ($i = 0; $i < $num; $i++) { 
        $level = rand(0, 100); 
        $date  = rand(strtotime('2017-01-01 00:00:00'), strtotime('2017-12-30 23:59:59')); 
        $date  = date("Y-m-d H:i:s", $date); 
        $info  = "info_msg"; 
        $table2 = 'log_'.($num/10000).'_2'; 
        $sql = createSql($level, $date, $info, $table2); 
    } 
} 
 
$flag = 0; 
$sql = ''; 
$sql1 = array(); 
function createSql($level, $date, $info, $table) { 
    global $flag, $sql, $conn,$sql1; 
    $flag++; 
    $sql1[] = "($level, '$date', '$info')"; 
    if ($flag == 1000) { 
        $sql = "insert into $table (level, date, info)values".implode(',', $sql1).";"; 
        mysql_query($sql, $conn); 
        $flag = 0; 
        $sql = ''; 
        $sql1 = array(); 
        echo "$table 1000 success!!\n"; 
    } 
}
