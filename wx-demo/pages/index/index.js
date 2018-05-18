//index.js
//获取应用实例
var app = getApp();

Page({
  data: {
    resident: null,
    community: '请选择小区',
    array: [],
    imgUrls:[
      '../images/index/1.png',
      '../images/index/2.png',
      '../images/index/3.png'
    ],
    articleList:[],
    notice:''
  },
  
  onLoad: function () {
    if (app.appData.userInfo == null) {
      wx.redirectTo({ url: "../login/login" })
    }
    var that = this;
    this.setData({
      resident: app.appData.userInfo
    })

    // 加载每日微文
    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/article/getArticleList.action',
      data:{
        cid: 171115120856
      }, 
      header: {
        'content-type': 'application/x-www-form-urlencoded' // post
      },
      method:'POST',
      success: function (res) {
        that.setData({
          articleList:res.data.message
        })
      }
    })

    // 加载社区
    if (null !== app.appData.userInfo.id) {
      wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/community/getCommunityListByRid.action',
        data: {
          rid: app.appData.userInfo.id
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function (res) {
          if (1 == res.data.status) {
            that.setData({
              array:res.data.message
            })
          }
        }
      })
    }

    //加载最新的社区通知
    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/notice/getNoticeNew.action',
      data: {
        cid: 171115120856
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // post
      },
      method: 'POST',
      success: function(res) {
        that.setData({
          notice: res.data.message
        })
      }
    })



  },





  bindPickerChange:function(e){
    var that=this;
    this.setData({
      community:this.data.array[e.detail.value].name
    })
    app.appData.communityInfo=that.data.array[e.detail.value]
  },

  notice:function(e){
    if (null != app.appData.communityInfo) {
      wx.navigateTo({
        url: '../function/notice/notice',
      })
    } else {
      wx.showToast({
        title: '请选择社区',
        icon: 'loading',
        duration: 1000
      })
    }
  },

  fault: function (e) {
    if (null != app.appData.communityInfo) {
      wx.navigateTo({
        url: '../function/fault/fault',
      })
    } else {
      wx.showToast({
        title: '请选择社区',
        icon: 'loading',
        duration: 1000
      })
    }
  },

  pay: function (e) {
    if (null != app.appData.communityInfo) {
      wx.navigateTo({
        url: '../function/pay/pay',
      })
    } else {
      wx.showToast({
        title: '请选择社区',
        icon: 'loading',
        duration: 1000
      })
    }
    
  },

  contact: function (e) {
    if(null!=app.appData.communityInfo){
      wx.navigateTo({
        url: '../function/contact/contact',
      })
    } else {
      wx.showToast({
        title: '请选择社区',
        icon: 'loading',
        duration: 1000
      })
    }
  },


  toArticle: function(e){
    var aid = e.currentTarget.id

    wx.navigateTo({
      url: 'article/article?id=' + aid
    })
  }







})