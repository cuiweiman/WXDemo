

Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },


  list:function(){
    wx.navigateTo({
      url: 'list/list',
    })
  },

  report:function(){
    wx.navigateTo({
      url: 'report/report',
    })
  }


})