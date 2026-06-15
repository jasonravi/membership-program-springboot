package com.firstclub.controller;

import com.firstclub.catalog.MembershipPlanCatalog;
import com.firstclub.domain.subscription.Subscription;
import com.firstclub.dto.request.SubscribeRequest;
import com.firstclub.dto.response.SubscriptionResponse;
import com.firstclub.service.MembershipService;
import jakarta.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memberships")
public class MembershipController {

    private final MembershipService service;

    public MembershipController(
            MembershipService service) {

        this.service = service;
    }

    @GetMapping("/plans")
    public ResponseEntity<?> plans() {

        return ResponseEntity.ok(
                MembershipPlanCatalog.getPlans()
        );
    }

    @PostMapping("/subscribe")
    public ResponseEntity<SubscriptionResponse>
    subscribe(
            @Valid
            @RequestBody
            SubscribeRequest request) {

        Subscription subscription =
                service.subscribe(request);

        return ResponseEntity.ok(
                SubscriptionResponse.from(
                        subscription
                )
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<SubscriptionResponse>
    currentMembership(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                SubscriptionResponse.from(
                        service.getCurrentMembership(
                                userId
                        )
                )
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void>
    cancelMembership(
            @PathVariable String userId) {

        service.cancel(userId);

        return ResponseEntity.noContent()
                .build();
    }

    @PostMapping("/{userId}/upgrade")
    public ResponseEntity<SubscriptionResponse>
    upgrade(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                SubscriptionResponse.from(
                        service.upgrade(userId)
                )
        );
    }

    @PostMapping("/{userId}/downgrade")
    public ResponseEntity<SubscriptionResponse>
    downgrade(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                SubscriptionResponse.from(
                        service.downgrade(userId)
                )
        );
    }
}