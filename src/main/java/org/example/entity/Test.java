package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * jpa entity for tests.
 */
@Entity
@Table(name = "tests")
@Data
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(name = "passing_score")
    private Integer passingScore = 80;
}