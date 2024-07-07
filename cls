[1mdiff --git a/src/main/java/com/example/springbootweb/controller/JwtTokenController.java b/src/main/java/com/example/springbootweb/controller/JwtTokenController.java[m
[1mindex 82ada3b..22b75c8 100644[m
[1m--- a/src/main/java/com/example/springbootweb/controller/JwtTokenController.java[m
[1m+++ b/src/main/java/com/example/springbootweb/controller/JwtTokenController.java[m
[36m@@ -30,6 +30,7 @@[m [mpublic class JwtTokenController {[m
 [m
         System.out.println("hi");[m
         System.out.println("hello");[m
[32m+[m[32m        System.out.println("welcome");[m
 [m
         if(authentication.isAuthenticated()){[m
             String token=jwtUtility.GenerateToken(jwtRequest.getUsername());[m
