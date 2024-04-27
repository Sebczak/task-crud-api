package com.crud.tasks.domain;

import lombok.Data;

@Data
public class Badges {

    private int votes;
    private AttachmentsByType attachmentsByType;
}
