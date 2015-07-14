package com.parallel6.captivereachconnectsdk.network.request;

public interface TaskListener {
   void onTaskCancelled();

   void onTaskFailure(Exception var1);

   void onTaskSuccess(Object var1);

   void onTaskTimeOut();
}
