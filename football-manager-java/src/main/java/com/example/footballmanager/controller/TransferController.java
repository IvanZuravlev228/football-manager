package com.example.footballmanager.controller;

import com.example.footballmanager.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final TransferService transferService;

    @Transactional
    @GetMapping
    public void createTransfer(@RequestParam Long fromTeamId,
                               @RequestParam Long toTeamId,
                               @RequestParam Long playerId) {
        System.out.println("Create transfer. FromTeamId: "
                + fromTeamId + " toTeamId: " + toTeamId + ", playerId: " + playerId);
        transferService.moveToOtherTeam(fromTeamId, toTeamId, playerId);
    }
}
