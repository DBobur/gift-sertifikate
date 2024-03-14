package com.example.giftsertifikate.service.tag;

import com.example.giftsertifikate.entity.GiftSertificate;
import com.example.giftsertifikate.entity.Tag;
import com.example.giftsertifikate.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{
    private final TagRepository tagRepository;

    @Override
    public Tag add(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void changes(List<Tag> tags, GiftSertificate giftSertificate) {
        for (Tag tag : tags) {
//            List<GiftSertificate> giftSertificates = tag.getGiftSertificates();
//            giftSertificates.add(giftSertificate);
//            tag.setGiftSertificates(giftSertificates);
//            tagRepository.save(tag);
        }
    }
}
