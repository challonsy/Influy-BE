package com.influy.domain.announcement.service;

import com.influy.domain.announcement.dto.AnnouncementRequestDTO;
import com.influy.domain.announcement.entity.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnouncementService {
    Page<Announcement> getAnnouncementsOf(Long sellerId, Pageable pageable);

    Announcement getPrimaryAnnouncementOf(Long sellerId);

    Announcement addAnnouncementOf(Long sellerId, AnnouncementRequestDTO requestDTO);

    Announcement updateAnnouncement(Long announcementId, AnnouncementRequestDTO requestDTO, Long sellerId, Boolean isPrimary);

    void deleteAnnouncement(Long sellerId, Long announcementId);
}
