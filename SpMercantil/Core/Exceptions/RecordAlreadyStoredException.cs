using System;

namespace Core.Exceptions
{
    public class RecordAlreadyStoredException : Exception
    {
        public string Id { get; }
        public string Type { get; }

        public RecordAlreadyStoredException(string id, string type, Exception inner) : base($"Record id={id} already stored. Type={type}", inner)
        {
            Id = id;
            Type = type;
        }

        public RecordAlreadyStoredException(string id, string type) : this(id, type, null) { }
    }
}