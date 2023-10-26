package com.example.gogotrips.comment.domain.entity;

import com.example.gogotrips.publication.domain.entity.Publication;
import com.example.gogotrips.shared.model.AuditModel;
import com.example.gogotrips.traveler.domain.entity.Traveler;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @NotEmpty
    private String contenido;

    @NotNull
    private Integer calificacion;

}
