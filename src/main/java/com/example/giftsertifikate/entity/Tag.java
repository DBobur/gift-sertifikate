package com.example.giftsertifikate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String name;
//    @ManyToMany
//    @JoinTable(
//            name = "tag_gift",
//            joinColumns = @JoinColumn(name = "tag_name"),
//            inverseJoinColumns = @JoinColumn(name = "gift_sertificate_name")
//    )
//    private List<GiftSertificate> giftSertificates = new ArrayList<>();
}
