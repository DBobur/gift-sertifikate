package com.example.giftsertifikate.service.gift_sertificate;

import com.example.giftsertifikate.controller.dto.GiftSertificateDto;
import com.example.giftsertifikate.controller.dto.SearchDto;
import com.example.giftsertifikate.controller.dto.TagDto;
import com.example.giftsertifikate.entity.GiftSertificate;
import com.example.giftsertifikate.entity.Tag;
import com.example.giftsertifikate.repository.GiftSertificateRepository;
import com.example.giftsertifikate.repository.TagRepository;
import com.example.giftsertifikate.service.gift_sertificate.GiftSertificateService;
import com.example.giftsertifikate.service.tag.TagService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftSertificateServiceImpl implements GiftSertificateService {
    private final GiftSertificateRepository giftSertificateRepository;
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;
    private final TagService tagService;

//    @Override
//    public GiftSertificate add(GiftSertificate giftSertificate) {
////        List<GiftSertificate> giftSertificates = tag.getGiftSertificates();
////        giftSertificates.add(giftSertificate);
////        tag.setGiftSertificates(giftSertificates);
////        tag = tagRepository.save(tag);
////        tags1.add(tag);
//        List<Tag> tags = giftSertificate.getTags();
//        List<Tag> tags1 = new ArrayList<>();
//        for (Tag tag : tags) {
//            Tag tag1 = tag;
//            if(tagRepository.searchByName(tag.getName())==null){
//                tag1 = tagRepository.save(tag);
//            }
//            tags1.add(tag1);
//        }
//        giftSertificate.setTags(tags1);
//        return giftSertificateRepository.save(giftSertificate);
//    }


    @Override
    public GiftSertificateDto add(GiftSertificateDto giftSertificateDto) {
        List<Tag> tags = new ArrayList<>(); // list yaratib oldik

        for (TagDto tag: giftSertificateDto.getTags()) {
            Tag tag1 = tagRepository.searchByName(tag.getName());// qidirib ko'ramiz agar oldin bunday tag bo'lsa shuni qaytaramiz
            if(tag1 == null){//agar oldin bunday tag b'lmasa qayta yaratamiz
                tag1 = tagRepository.save(modelMapper.map(tag,Tag.class));
            }
            tags.add(tag1);
        }

        GiftSertificate giftSertificate = GiftSertificate.builder()
                .name(giftSertificateDto.getName())
                .description(giftSertificateDto.getDescription())
                .tags(tags)
                .build();

        giftSertificateRepository.save(giftSertificate);
        //tagService.changes(tags,giftSertificate);
        return giftSertificateDto;
    }

    @Override
    public List<GiftSertificate> getSearchGifts(Pageable pageable, SearchDto searchDto) {
        if(searchDto.getSearchBy().equals("tag")){
            return giftSertificateRepository.findByTagsName(searchDto.getSearchName(), pageable).getContent();
        }else if(searchDto.getSearchBy().equals("name")){
            return giftSertificateRepository.findAllByNameContains(searchDto.getSearchName(),pageable).getContent();
        }
        return giftSertificateRepository.findAllByDescriptionContains(searchDto.getSearchName(),pageable).getContent();

    }


}
