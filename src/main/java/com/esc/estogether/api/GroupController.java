package com.esc.estogether.api;

import com.esc.estogether.model.parameter.GroupSearch;
import com.esc.estogether.service.GroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping("")
    public ResponseEntity<?> findAll(GroupSearch groupSearch) {
        return ResponseEntity.ok().body(groupService.findAll(groupSearch));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> findGroupById(@PathVariable Integer groupId,
                                           GroupSearch groupSearch) {
        groupSearch.setId(groupId);
        return ResponseEntity.ok().body(groupService.findGroupById(groupSearch));
    }

    @GetMapping("/reader/{readerId}")
    public ResponseEntity<?> findGroupByReaderId(@PathVariable Integer readerId,
                                                 GroupSearch groupSearch) {
        groupSearch.setReaderId(readerId);
        return ResponseEntity.ok().body(groupService.findGroupByReaderId(groupSearch));
    }
}
