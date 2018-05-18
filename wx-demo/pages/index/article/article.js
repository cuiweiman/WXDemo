// pages/index/article/article.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    article:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var that=this;
      var id=options.id;
      wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/article/getArticleById.action',
        data: {
          aid: id
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function(res) {
          that.setData({
              article:res.data.message
          })
        }
      })
      
  },

})