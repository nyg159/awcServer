package team.awc1.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.awc1.member.controller.dto.JoinREquest;
import team.awc1.member.repository.entity.Member;
import team.awc1.member.service.MemberSerive;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberSerive memberSerive;

    @PostMapping("/join")
    public String join(@RequestBody JoinREquest joinREquest){

        String id = joinREquest.getId();
        String name = joinREquest.getName();
        String passWord = joinREquest.getPassWord();

        String result = memberSerive.join(id, name, passWord);

        if("success".equalsIgnoreCase(result)){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/test")
    public JoinREquest test(){
        JoinREquest joinREquest = new JoinREquest();
        joinREquest.setId("test");
        joinREquest.setName("pass");

        return joinREquest;
    }

}
