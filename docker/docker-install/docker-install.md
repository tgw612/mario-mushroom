docker安装

安装mysql
docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=rich@678 mysql:latest
搭建maven私有仓库
https://www.jianshu.com/p/09a6cab3785a
docker run -d -p 8081:8081 --name nexus -v /root/nexus-data:/var/nexus-data --restart=always sonatype/nexus3
    docker exec -it 511d6878bca5 /bin/bash
    获取登陆密码
    cd nexus-data/
    cat admin.password 登录后可以自定义修改密码
安装redis
docker run --name redis -p 6379:6379 -d redis
安装zookeeper
docker run --name zookeeper --restart always -d zookeeper


docker 镜像加速
sudo cp -n /lib/systemd/system/docker.service /etc/systemd/system/docker.service
sudo sed -i "s|ExecStart=/usr/bin/docker daemon|ExecStart=/usr/bin/docker daemon --registry-mirror=<your accelerate address>|g" /etc/systemd/system/docker.service
sudo sed -i "s|ExecStart=/usr/bin/dockerd|ExecStart=/usr/bin/dockerd --registry-mirror=<your accelerate address>|g" /etc/systemd/system/docker.service
sudo systemctl daemon-reload
sudo service docker restart

