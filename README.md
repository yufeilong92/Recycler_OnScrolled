# Recycler_OnScrolled
 ![image](https://github.com/yufeilong92/Recycler_OnScrolled/blob/master/a/a.gif)
 ```
     private void initData() {
         List<String> list = new ArrayList<>();
         for (int i = 0; i < 80; i++) {
             list.add("String =" + i);
         }
         final GridLayoutManager manager = new GridLayoutManager(this, 1);
         manager.setOrientation(GridLayoutManager.VERTICAL);
         mRlvContent.setLayoutManager(manager);
         RlcAdapter adapter = new RlcAdapter(this, list);
         mRlvContent.setAdapter(adapter);
         mRlvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
             @Override
             public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                 super.onScrolled(recyclerView, dx, dy);
                 float alphaFloat = getAlphaFloat(getScroolY(manager));
                 mLlBar.setAlpha(alphaFloat);
             }
         });
     }
     /**
      * 获取滑动距离
      *
      * @param manager
      * @return
      */
     private int getScroolY(GridLayoutManager manager) {
         View c = mRlvContent.getChildAt(0);
         if (c == null)
             return 0;
         int i = manager.findFirstVisibleItemPosition();
         int top = c.getTop();
         /**
          * 声明一下，这里测试得到的top值始终是RecyclerView条目中显示的第一条距离顶部的距离，
          * 而这个在坐标中的表示是一个负数，所以需要对其取一个绝对值
          */
         return i * c.getHeight() + Math.abs(top);
     }

     /**
      * 更具相应位子显示相应的透明度
      *
      * @param dis
      * @return
      */
     private float getAlphaFloat(int dis) {
         int step = 200;
         if (dis == 0) {
             return 0.0f;
         }
         if (dis < step) {
             return (float) (dis * (1.0 / step));
         } else {
             return 1.0f;
         }
     }

 ```
