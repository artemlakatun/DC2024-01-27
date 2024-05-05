using Lab4.Publisher.DTO.RequestDTO;
using Lab4.Publisher.DTO.ResponseDTO;

namespace Lab4.Publisher.HttpClients.Interfaces;

public interface IDiscussionClient
{
    Task<IEnumerable<NoteResponseDto>> GetNotesAsync();

    Task<NoteResponseDto> GetNoteByIdAsync(long id);

    Task<NoteResponseDto> CreateNoteAsync(NoteRequestDto post);

    Task<NoteResponseDto> UpdateNoteAsync(NoteRequestDto post);

    Task DeleteNoteAsync(long id);
}