// pages/function/fault/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      fault:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    var that=this;
    var id = options.id;

      wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/fault/findFaultById.action',
        data: {
            fid:id
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function(res) {
          if(1==res.data.status){
            that.setData({
              fault: res.data.message
            })
          }

        },
      })


  }







})