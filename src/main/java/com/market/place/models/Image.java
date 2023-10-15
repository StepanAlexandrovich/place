package com.market.place.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "original_file_name")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Product product;
    @Column(name = "content_type")
    private String contentType;
}
