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
@Table(name = "gift_sertificate")
public class GiftSertificate extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "gift_tags",
            joinColumns = @JoinColumn(name = "gift_sertificate_name"),
            inverseJoinColumns = @JoinColumn(name = "tag_name")

    )
    private List<Tag> tags;
}
