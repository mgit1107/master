package map;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MapDemo {

    public static void main(String[] args) throws Exception {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
//                int value = map.get("key") + 1;//第一步 值+1
//                map.put("key", value);//第二步,重新设值
                calculate(map);
            });
        }
        TimeUnit.SECONDS.sleep(5l);
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    public static synchronized void calculate(ConcurrentHashMap<String, Integer> map){
        int value = map.get("key") + 1;//第一步 值+1
        map.put("key", value);//第二步,重新设值
    }
}
