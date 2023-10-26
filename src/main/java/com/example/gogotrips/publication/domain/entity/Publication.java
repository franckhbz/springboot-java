package com.example.gogotrips.publication.domain.entity;

import com.example.gogotrips.comment.domain.entity.Comment;
import com.example.gogotrips.forum.domain.entity.Forum;
import com.example.gogotrips.shared.model.AuditModel;
import com.example.gogotrips.traveler.domain.entity.Traveler;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "publication")
@AllArgsConstructor
@NoArgsConstructor
public class Publication extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publication_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler traveler;

    @OneToMany(mappedBy = "publication")
    private Collection<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "publications_forums",
            joinColumns = @JoinColumn(name = "publication_id"),
            inverseJoinColumns = @JoinColumn(name = "forum_id")
    )
    private Collection<Forum> forums;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

}
