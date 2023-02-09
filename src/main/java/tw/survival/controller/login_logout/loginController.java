package tw.survival.controller.login_logout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import tw.survival.service.Player.PlayerService;

@Controller
public class loginController {

   @Autowired
   public PlayerService pService;
   
   

}
