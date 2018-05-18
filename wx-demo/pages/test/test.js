function countdown(that) {
  var second = that.data.second  
  if (second == 0) {    // console.log("Time Out...");
    that.setData({
      second: "Time Out..."
    }); return;
  } 
  var time = setTimeout(function () {
    that.setData({
      second: second - 1
    });
    countdown(that);
  }
    , 1000)
}

Page({
  data: {
    second: 59
  },
  onLoad: function () {
    var that=this
    console.log(that.data.second)
    countdown(this);
  }
});
