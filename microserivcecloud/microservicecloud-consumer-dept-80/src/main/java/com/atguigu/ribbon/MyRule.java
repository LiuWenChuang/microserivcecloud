package com.atguigu.ribbon;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.servo.jsr166e.ThreadLocalRandom;

public class MyRule extends AbstractLoadBalancerRule {
	 
	private int totocount = 0; //计算访问的次数 ，等于或者大于五次 则进行 返回
	
	private int chooseindex = 0; //获取有效服务的下标
 
   @Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
    * Randomly choose from all living servers
    */
   public Server choose(ILoadBalancer lb, Object key) {
       if (lb == null) {
           return null;
       }
       Server server = null;

       while (server == null) {
           if (Thread.interrupted()) {
               return null;
           }
           List<Server> upList = lb.getReachableServers();
           List<Server> allList = lb.getAllServers();

           int serverCount = allList.size();
           if (serverCount == 0) {
               /*
                * No servers. End regardless of pass, because subsequent passes
                * only get more restrictive.
                */
               return null;
           }

//           int index = chooseRandomInt(serverCount);
//           server = upList.get(index);
           
            if(totocount < 5) {
           	 server = upList.get(chooseindex);
           	 totocount++;
            }else {
             	 totocount = 0;
             	 chooseindex++;
              	 if(chooseindex >= upList.size()) {//当 下标超出的时候进行重置为0
              		chooseindex =0;
              	 }
            }
           

           if (server == null) {
               /*
                * The only time this should happen is if the server list were
                * somehow trimmed. This is a transient condition. Retry after
                * yielding.
                */
               Thread.yield();
               continue;
           }

           if (server.isAlive()) {
               return (server);
           }

           // Shouldn't actually happen.. but must be transient or a bug.
           server = null;
           Thread.yield();
       }

       return server;

   }

   protected int chooseRandomInt(int serverCount) {
       return ThreadLocalRandom.current().nextInt(serverCount);
   }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}
}
