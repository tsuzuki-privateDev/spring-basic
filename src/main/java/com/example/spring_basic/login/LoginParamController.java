package com.example.spring_basic.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginParamController {
    @GetMapping("/loginParam1")
    // GETパラメータ（任意）を受け取る
    public String loginParam1(
        @RequestParam(required = false) String id, 
        @RequestParam(required =  false) String pass
        ) {
            // GETパラメータが指定されていない場合
            if (id == null || pass == null) {
                return "ログイン情報を入力してください。";
            }
            // GETパラメータが空文字だった場合
            if (id.equals("") || pass.equals("")) {
                return "ログインに失敗しました。";
            } else {
                return "ログインに成功しました（ID：" + id + "、PASS：" + pass + "）";
            }
    }

    @GetMapping("/loginParam2/{id}/{pass}")
    public String loginParam2(@PathVariable String id, @PathVariable String pass) {
        if (id.equals("") || pass.equals("")) {
            return "ログインに失敗しました。";
        }
        return "ログインに成功しました（ID：" + id + "、PASS：" + pass + "）";
    }
}
