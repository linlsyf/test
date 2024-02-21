#! /bin/bash

#chmod 777 -R   /root/GitHub_Action/run.sh

jarname=test
pid=`   ps -ef | grep  $jarname | grep   java | awk '{print $2}'   `
echo this  $jarname
echo pid=  $pid

if  [ -z $pid ]; then
  echo "$jarname   未运行"
else 
     echo "准备关闭进程$pid"

     kill -9 $pid
   sleep 0.5

echo "已关闭进程$pid"
  fi
  echo ps -ef | grep  '$jarname'  


#nohup   

echo "stop  end"


echo "开始重启服务..."

  source /etc/profile;java -jar /root/GitHub_Action/test.jar &

echo "长期服务完成 "


#ps -ef | grep  eureka-server | grep   java | awk '{print $2}'
#  killall   eureka-server   lsof -i:







