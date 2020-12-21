## **mysql  windows版本安装（建议5.7版本，较稳定）**

#### 1.下载地址：https://downloads.mysql.com/archives/community/

![](D:\teach\mysql安装\1.jpg)

#### 2.下载完成后解压至安装目录

#### 3.配置MySQL环境变量，步骤如下：

win10：此电脑右击 -> 高级系统设置 -> 环境变量，系统变量找到path，编辑->新建，然后找到安装目录mysql中的bin文件目录（我的：D:\development\mysql-5.7.31-winx64\bin），点击确定；

#### 4.进入dos命令窗口，切换到mysql中的bin文件目录下，输入命令mysqld --initialize-insecure --user=mysql，生成data文件夹

![](D:\teach\2.jpg

![](D:\teach\mysql安装\2.jpg)

#### 5.继续执行命令mysqld -install，此时界面提示服务安装成功。

![image-20201216171328623](D:\teach\mysql安装\image-20201216171328623.png)

#### 6.执行命令net start MySQL，此时界面提示服务启动成功,此时安装完毕。

![image-20201216171449843](D:\teach\mysql安装\image-20201216171449843.png)

#### 7.使用数据库操作软件即可使用，用户名root，无密码；



使用：mysql -u root -p 登录

set password for root@localhost = password('要修改的密码'); 修改密码

