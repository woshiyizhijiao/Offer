# Study
# 接口
## 1.App更新

{
	"code": 0,
	"data": {
		"apkUrl": "http://xxxxx.apk",
		"constraint": false,
		"describe": "最新1.1版本，增强了用户体验",
		"versionCode": 2,
		"versionName": "1.1"
	},
	"message": "成功"
}

apkUrl: apk下载地址
constraint: 是否强制更新
describe: 更新内容
versionCode: 版本号
versionName: 版本名称

## 2.首页课程列表（分为视频和音频，传入type判断返回视频还是音频）

{
	"code": 0,
	"data": {
		"courseList": [{
			"courseCover": "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u\u003d230255013,842554329\u0026fm\u003d26\u0026gp\u003d0.jpg",
			"courseLecturer": "这个是课程的讲师",
			"courseName": "焦洋情感歌预售，99快5毛钱一本，焦洋颓废的生活，开篇，第一本，这个书名真的很长0",
			"id": 0,
			"type": 0
		}, {
			"courseCover": "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u\u003d230255013,842554329\u0026fm\u003d26\u0026gp\u003d0.jpg",
			"courseLecturer": "这个是课程的讲师",
			"courseName": "焦洋情感歌预售，99快5毛钱一本，焦洋颓废的生活，开篇，第一本，这个书名真的很长1",
			"id": 1,
			"type": 1
		}]
	},
	"message": "成功"
}

courseCover：课程封面图片
courseLecturer：课程讲师
courseName：课程名称
id：课程id
type：课程类型 0视频 1音频

## 3. 课程详情

{
	"courseCover": "http://img3.imgtn.bdimg.com/it/u\u003d519154190,1957368541\u0026fm\u003d26\u0026gp\u003d0.jpg",
	"courseDescription": "英语基础语法学习，针对0基础的同学，你想学习么，那就快来吧",
	"courseId": 0,
	"courseLecturer": "焦洋老师",
	"courseName": "英语基础语法学习",
	"courseType": 0,
	"voiceCatalogueList": [{
		"catalogueId": 0,
		"catalogueLecturer": "讲师名称",
		"catalogueName": "0这是是视频的标题0",
		"catalogueSize": 10000,
		"catalogueUrl": "",
		"switchVideoModels": [{
			"name": "普通",
			"url": "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4"
		}, {
			"name": "高清",
			"url": "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4"
		}]
	}]
}

courseCover：课程封面地址
courseDescription：课程描述
courseId：课程id
courseLecturer：课程讲师名称
courseName：课程名称
courseType：课程类型
voiceCatalogueList：「
	catalogueId：章节id
    catalogueLecturer：讲师名称
	catalogueName：章节名称
	catalogueSize：章节长度 毫秒
    catalogueUrl：音频播放的地址 视频的播放地址是 switchVideoModels
    switchVideoModels「
    			name：高清/超清
                url：高清/超清地址
	」
」
