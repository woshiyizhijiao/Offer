# 记录下可能需要用到的
## markdown常见用法
http://www.jianshu.com/p/q81RER
## Studio常见错误
1. Error:This Gradle plugin requires Studio 3.0 minimum
> 将以下内容添加到gradle.properties中：android.injected.build.model.only.versioned = 3
2. Error:No service of type Factory available in ProjectScopeServices.
> 直接将' classpath com.github.dcendents:android-maven-gradle-plugin:1.3'更新到1.4.1就可以解决问题了。
