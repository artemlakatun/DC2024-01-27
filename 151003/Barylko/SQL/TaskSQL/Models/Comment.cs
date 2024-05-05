﻿using System.ComponentModel.DataAnnotations;

namespace TaskREST.Models;

public class Comment
{
    public long id{ get; set; }
    public long IssueId { get; set; }
    [MaxLength(2048)] public string Content { get; set; } = string.Empty;
}