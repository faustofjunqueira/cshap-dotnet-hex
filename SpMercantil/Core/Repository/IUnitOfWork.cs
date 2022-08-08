namespace Core.Repository
{
    /// <summary>
    ///     Implemetação da unit of work
    /// </summary>
    public interface IUnitOfWork
    {
        IMarketRepository Market { get; }
    }
}