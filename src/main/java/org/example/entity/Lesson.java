package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * jpa entity for lessons with video support.
 */
@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "video_url", length = 500)
    private String videoUrl;

    @Column(name = "video_type", length = 50)
    private String videoType;   // YOUTUBE, VIMEO, LOCAL

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;
}