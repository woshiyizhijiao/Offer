# 记录下可能需要用到的
## markdown常见用法
http://www.jianshu.com/p/q81RER
## Studio常见错误
1. Error:This Gradle plugin requires Studio 3.0 minimum
> 将以下内容添加到gradle.properties中：android.injected.build.model.only.versioned = 3

2. Error:No service of type Factory available in ProjectScopeServices.
> 将' classpath com.github.dcendents:android-maven-gradle-plugin:1.3'更新到1.4.1

3.Error:android-apt plugin is incompatible with the Android Gradle plugin.  Please use 'annotationProcessor' configuration instead.
> 把project目录下的build.gradle中的classpath ‘com.neenbedankt.gradle.plugins:android-apt:1.8'删除掉;
> 把具体Module目录下的build.gradle中的apply plugin: ‘com.neenbedankt.android-apt’删除； 
> 同时把dependencies中原来使用apt的改为annotationProcessor，然后Sync Now即可
