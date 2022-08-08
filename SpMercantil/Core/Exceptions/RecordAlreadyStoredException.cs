using System;

namespace Core.Exceptions
{
    public class RecordNotFoundException : Exception
    {
        public string Id { get; }
        public string Type { get; }

        public RecordNotFoundException(string id, string type, Exception inner) : base($"Record id={id} not found. Type={type}", inner)
        {
            Id = id;
            Type = type;
        }

        public RecordNotFoundException(string id, string type) : this(id, type, null) { }
    }
}