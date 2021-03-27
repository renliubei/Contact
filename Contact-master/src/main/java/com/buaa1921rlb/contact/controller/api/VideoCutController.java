package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.VideoCut;
import com.buaa1921rlb.contact.services.VIdeoCutService;
import org.springframework.web.bind.annotation.GetMapping;

public class VideoCutController {
    private VIdeoCutService vIdeoCutService;
    @GetMapping("/getcut1")
    public String getById(long Id){return vIdeoCutService.getById(Id).getSourceUrl();}
    @GetMapping("/getcut2")
    public String countByAuthor(Integer authorId){return vIdeoCutService.countByAuthor(authorId).toString();}
}
